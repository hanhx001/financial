/**
 * 
 */
package com.iboyaa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.iboyaa.dao.loginUserDao;
import com.iboyaa.pojo.SharesInfo;
import com.iboyaa.pojo.loginUser;
import com.iboyaa.service.ILoginUserService;
import com.iboyaa.util.PageInfoExtend;
import com.iboyaa.util.StringIsNull;

/**
 * @author 清水贤人
 *
 */
@Service("loginUserServiceI")
public class ILoginUserServiceImpl implements ILoginUserService {

    @Resource
    private loginUserDao loginUserDao;

    public ILoginUserServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.ILoginUserService#insertSelective(com.iboyaa.pojo.loginUser)
     */
    @Override
    public int insertSelective(loginUser record) {
        // TODO Auto-generated method stub
        return loginUserDao.insertSelective(record);
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.ILoginUserService#selectByPrimaryKey(java.lang.Integer)
     */
    @Override
    public loginUser selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return loginUserDao.selectByPrimaryKey(id);
    }

    /* (non-Javadoc)
     * @see com.iboyaa.service.ILoginUserService#updateByPrimaryKeySelective(com.iboyaa.pojo.loginUser)
     */
    @Override
    public int updateByPrimaryKeySelective(loginUser record) {
        // TODO Auto-generated method stub
        return loginUserDao.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<loginUser> getLoginUserInfoByCondition(String startDate, String endDate,
            String keyWord, Integer pageNum, Integer pageSize) {


        DateTime nowTime = new DateTime();

        //如果时间都为空，则查询当天的数据
        if (StringIsNull.isNULL(startDate) && StringIsNull.isNULL(endDate)) {
            startDate = nowTime.toString("yyyy-MM-dd");
            endDate = nowTime.toString("yyyy-MM-dd");
        }

        List<loginUser> totalData = loginUserDao.getLoginUserInfoByCondition(startDate, endDate,
                keyWord, pageNum, pageSize);
        Integer totalNum =
                loginUserDao.getLoginUserInfoByCondition(startDate, endDate, keyWord).size();

        //封装分页参数
        PageInfo<loginUser> pageInfo = new PageInfo<loginUser>();
        pageInfo.setList(totalData);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(totalNum) ;
        
        return pageInfo;
    }

}
