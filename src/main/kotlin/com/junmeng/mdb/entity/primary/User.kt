package com.junmeng.mdb.entity.primary

/**
 * Created by hwj on 2017/7/10.
 */
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class User(
        @Id
        @GeneratedValue
        var id: Long? = null,

        @Column(nullable = false)
         var name: String? = null,

        @Column(nullable = false)
        var age: Int? = null
)