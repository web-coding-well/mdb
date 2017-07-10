package com.junmeng.mdb

import com.junmeng.mdb.entity.primary.User
import com.junmeng.mdb.entity.secondary.Message
import com.junmeng.mdb.repository.primary.UserRepo
import com.junmeng.mdb.repository.secondary.MessageRepo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.beans.factory.annotation.Autowired



@RunWith(SpringRunner::class)
@SpringBootTest
class MdbApplicationTests {
	@Autowired
	lateinit var userRepository: UserRepo
	@Autowired
	lateinit var messageRepository: MessageRepo
	@Test
	fun contextLoads() {

		userRepository.save(User(name="aaa", age=10))
		userRepository.save(User(name="bbb", age=20))
		userRepository.save(User(name="ccc", age=30))
		userRepository.save(User(name="ddd", age=40))
		userRepository.save(User(name="eee",age= 50))


		messageRepository.save(Message(name="o1", content="aaaaaaaaaa"))
		messageRepository.save(Message(name="o2", content="bbbbbbbbbb"))
		messageRepository.save(Message(name="o3", content="cccccccccc"))


	}

}
