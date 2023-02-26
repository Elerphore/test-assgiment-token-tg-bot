import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.lordcodes.turtle.ShellLocation
import com.lordcodes.turtle.shellRun

fun main(args: Array<String>) {
    val bot = bot {
        token = ""
        dispatch {
            command("start") {
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Enter /authorize O42GOKANL8 password")
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "And you will get the token")
            }
            command("authorize") {

                println("${this.args}")

                val laravelProject = ShellLocation.HOME.resolve("C:/projects/test-assigment")

                val token = shellRun("php", listOf("artisan", "command:authorize", this.args[0], this.args[1]), laravelProject)
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Your token is: $token")
            }
        }
    }
    bot.startPolling()
}