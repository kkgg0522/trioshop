package com.trioshop.repository.dao.user;

import com.trioshop.model.dto.user.*;
import com.trioshop.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJoinDao {
    private final UserMapper userMapper;

    public void saveUsers(UserJoin userJoin) {userMapper.saveUsers(userJoin);}
    public void saveUserInfo(UsersInfoEntity usersInfoEntity) {userMapper.saveUserInfo(usersInfoEntity);}
    // 사용자 아이디 중복 체크
    public boolean checkUserIdExists(String userId) {
        return userMapper.checkUserIdExists(userId) != null;
    }
    // 비회원으로 로그인
    public UserInfoBySession searchGuestUser (GuestUserLoginInfo guestUserLoginInfo) {
        return userMapper.searchGuestUser(guestUserLoginInfo);
    }
    public void insertUsersData(UsersEntity usersEntity) {
        userMapper.insertUsersData(usersEntity);
    }
    public void insertUsersInfoData(UsersInfoEntity usersInfoEntity) {
        userMapper.insertUsersInfoData(usersInfoEntity);
    }
    public Long selectUserCode(Object object) {
        return userMapper.selectUserCode(object);
    }
}
