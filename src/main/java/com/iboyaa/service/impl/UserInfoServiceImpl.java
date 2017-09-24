
package com.iboyaa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.iboyaa.dao.IUserInfoDao;
import com.iboyaa.pojo.UserInfo;
import com.iboyaa.service.IUserInfoService;
import com.iboyaa.util.StringIsNull;

/**
 * @author 清水贤人
 *
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Resource
    private IUserInfoDao userInfoDao;

    public UserInfoServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.IUserInfoService#deleteByPrimaryKey(java.lang.Integer)
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {

        return 0;
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.IUserInfoService#insert(com.iboyaa.pojo.UserInfo)
     */
    @Override
    public int insert(UserInfo record) {

        return 0;
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.IUserInfoService#insertSelective(com.iboyaa.pojo.UserInfo)
     */
    @Override
    public int insertSelective(UserInfo record) {

        return userInfoDao.insertSelective(record);
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.IUserInfoService#selectByPrimaryKey(java.lang.Integer)
     */
    @Override
    public UserInfo selectByPrimaryKey(Integer id) {

        return userInfoDao.selectByPrimaryKey(id);
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.IUserInfoService#updateByPrimaryKeySelective(com.iboyaa.pojo.UserInfo)
     */
    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {

        return userInfoDao.updateByPrimaryKey(record);
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.IUserInfoService#updateByPrimaryKey(com.iboyaa.pojo.UserInfo)
     */
    @Override
    public int updateByPrimaryKey(UserInfo record) {

        return 0;
    }

    @Override
    public PageInfo<UserInfo> getUserInfo(String startDate, String endDate, String keyWord,
            Integer state, Integer pageNum, Integer pageSize) {

        DateTime nowTime = new DateTime();

        //如果时间都为空，则查询当天的数据
        if (StringIsNull.isNULL(startDate) && StringIsNull.isNULL(endDate)) {
            startDate = nowTime.toString("yyyy-MM-dd");
            endDate = nowTime.toString("yyyy-MM-dd");
        }

        //查询返回数据
        List<UserInfo> dataWithPage = userInfoDao.getUserInfoByCondition(startDate, endDate,
                keyWord, state, pageNum, pageSize);
        //查询总分页数
        Integer totalNum =
                userInfoDao.getUserInfoByCondition(startDate, endDate, keyWord, state).size();

      //封装分页参数
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>();
        pageInfo.setList(dataWithPage);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(totalNum);

        return pageInfo;
    }

}
