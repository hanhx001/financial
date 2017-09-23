
package com.iboyaa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iboyaa.dao.IUserInfoDao;
import com.iboyaa.pojo.UserInfo;
import com.iboyaa.service.IUserInfoService;

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

}
