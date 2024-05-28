// UserInfoDao.java
package com.trioshop.repository.dao.user;

import com.trioshop.model.dto.user.*;
import com.trioshop.repository.mybatis.UserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserInfoDao {

    @Autowired
    private UserMapper userMapper;

    public UserInfoBySession loginUser(String userId, String userPasswd) {
        UserIdPasswd userIdPasswd = new UserIdPasswd(userId, userPasswd);
        return userMapper.loginUser(userIdPasswd);
    }

    public UserPatch findUserByUserCode(String userCode) {
        return userMapper.findUserByUserCode(userCode);
    }

    public UserFindId findId(String userName, String userTel) {
        return userMapper.findId(userName, userTel);
    }

    @Transactional
    public boolean findAndUpdatePw(UserFindPw userFindPw){
        try {
            UserFindPw result = userMapper.findPw(userFindPw.getUserName(), userFindPw.getUserId());
            if (result != null) {
                return userMapper.updatePw(userFindPw.getUserId(), userFindPw.getUserPasswd());
            } else {
                return false; // 일치하는 정보가 없을 경우
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 에러 발생 시
        }
    }


    @Transactional
    public boolean saveUserInfo(UserJoin userJoin) {
        try {
            userMapper.saveUsers(userJoin);
            userMapper.saveUserInfo(userJoin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean patchUser(UserPatch userPatch) {
        try {
            boolean patchUserSuccess = userMapper.patchUser(userPatch);
            boolean patchUserPwSuccess = userMapper.patchUserPw(userPatch);
            return patchUserSuccess && patchUserPwSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changedInfo(UserPatch userPatch) {
        return userPatch.getUserNickname() != null ||
                userPatch.getUserAddress() != null ||
                userPatch.getUserTel() != null;
    }

}

