package org.jetbrains.kotlin.course.duck.shop.functions.change

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.jetbrains.kotlin.course.duck.shop.duck.generateRandomDuck
import org.jetbrains.kotlin.course.duck.shop.duck.getDescription
import org.springframework.stereotype.Service

@Service
class GameChangeFunctionsService  {
    fun MutableList<Duck>.addRandomDuck(): Duck = generateRandomDuck()

    fun MutableSet<Duck>.addRandomDuck(): Duck = Duck.entries.minus(this).random()

    fun MutableMap<Duck, String>.addRandomDuck(): Pair<Duck, String> =
        Duck.entries.minus(keys).random().let { it to it.getDescription() }


    fun List<Duck>.removeRandomDuck(): List<Duck> = this.toMutableList().apply { remove(this.random()) }

    fun Set<Duck>.removeRandomDuck(): Set<Duck> = this.toMutableSet().apply { remove(this.random()) }

    fun Map<Duck, String>.removeRandomDuck(): Map<Duck, String> = toMutableMap().apply { remove(this.keys.random()) }
}
