package com.junmeng.mdb.repository.primary

import com.junmeng.mdb.entity.primary.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by hwj on 2017/7/10.
 */
interface UserRepo: JpaRepository<User, Long> {
}