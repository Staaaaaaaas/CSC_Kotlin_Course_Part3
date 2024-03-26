package org.jetbrains.kotlin.course.tamagotchi.game

import org.jetbrains.kotlin.course.tamagotchi.models.Command
import org.jetbrains.kotlin.course.tamagotchi.models.Mode
import org.springframework.stereotype.Service

@Service
class GameService {
    val commands = ArrayDeque<Command>()
    companion object {
        private const val MAX_CAPACITY = 16
    }

    fun addCommand(command: Command): Boolean
    = (commands.size < MAX_CAPACITY).also { if(it) commands.addLast(command) }

    fun getCommand(mode: Mode): Command? = when(mode) {
        Mode.Queue -> commands.removeFirstOrNull()
        Mode.Stack -> commands.removeLastOrNull()
    }
}
