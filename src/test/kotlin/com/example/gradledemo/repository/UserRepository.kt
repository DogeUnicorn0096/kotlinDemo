package com.example.gradledemo.repository

import com.example.gradledemo.entity.UserEntity
import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.flywaydb.test.annotation.FlywayTest
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@AutoConfigureEmbeddedDatabase
@FlywayTest
@ExtendWith(SpringExtension::class)
//@DirtiesContext
@DataJpaTest
//@SpringBootTest
//@Transactional
@DisplayName("test userRepository")
//@EmbeddedKafka(
//        count = 1,
//        partitions = 1,
//        brokerProperties = [
//            "listeners=PLAINTEXT://localhost:9092",
//            "auto.create.topics.enable=true",
//            "offsets.topic.replication.factor=1",
//            "transaction.state.log.replication.factor=1",
//            "min.insync.replicas=1",
//            "transaction.state.log.min.isr=1",
//            "log.dir=build/tmp/kafka/notification-update-command"
//        ],
//        topics = ["yyy"]
//)
class UserRepositoryTest {
//    @Autowired
//    private lateinit var embeddedKafka: EmbeddedKafkaBroker

    @Autowired
    private lateinit var userRepository: UserRepository

    private var user = UserEntity()


    @BeforeEach
    fun setUp() {
        user.account = "test_user"
        user.password = "123456"
        user.createTime = Date()
    }

        @Test
    @DisplayName("add user")
    fun addUser() {
        assertAll("insert user success",
                { Assertions.assertNotNull(userRepository.save(user)) },
                { Assertions.assertNotNull(user.id) }
        )
        println(user)

    }
//
//    @Test
//    @ParameterizedTest(name = "id-->account")
//    @CsvSource(
//            "1,root",
//            "6,root1"
//    )
//    @DisplayName("query user")
//    fun queryUserTest(id: Long, account: String) {
//        Assertions.assertEquals(account, userRepository.findById(id).get().account) {
//            "$id------>$account"
//        }
//    }

//    @BeforeEach
//    fun kafkaTest() {
//        val senderProps = KafkaTestUtils.producerProps(embeddedKafka)
//        val template = KafkaTemplate(DefaultKafkaProducerFactory<Int, String>(senderProps))
//        template.defaultTopic = "yyy"
//        template.sendDefault("foo")
//
//
//    }
//
//    @Test
//    @DisplayName("kafkaTest")
//    fun `Kafka Test`() {
//        var consumerProps = KafkaTestUtils.consumerProps("a", "true", embeddedKafka)
//        var cf = DefaultKafkaConsumerFactory<Int, String>(consumerProps)
//        var consumer = cf.createConsumer()
//        embeddedKafka.consumeFromAnEmbeddedTopic(consumer, "yyy")
//        var records = KafkaTestUtils.getRecords(consumer)
//        System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
//        records.forEach { System.err.println(it.value()) }
//        Assertions.assertFalse(records.isEmpty,"have message")
//
//    }
}