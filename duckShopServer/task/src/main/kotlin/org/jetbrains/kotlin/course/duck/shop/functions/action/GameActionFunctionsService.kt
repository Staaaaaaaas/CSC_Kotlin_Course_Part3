package org.jetbrains.kotlin.course.duck.shop.functions.action

import org.jetbrains.kotlin.course.duck.shop.duck.Duck
import org.springframework.stereotype.Service

@Service
class GameActionFunctionsService {

    fun List<Duck>.shuffleDucks(): List<Duck> = shuffled()

    fun List<Duck>.sortDucks(): List<Duck> =
        sortedByDescending { duck -> duck.accessories.sumOf { if(duck.hasKotlinAttribute) 100 * it.price else it.price } }

    fun Collection<Duck>.deleteDucksWithoutKotlinStuff(): Collection<Duck> = filter { it.hasKotlinAttribute }

    fun Map<Duck, String>.deleteDucksWithoutKotlinStuff(): Map<Duck, String> = filter { it.key.hasKotlinAttribute }

    fun Collection<Duck>.divideDucksIntoKotlinAndNonKotlin(): Pair<Collection<Duck>, Collection<Duck>> =
        deleteDucksWithoutKotlinStuff().let {it to this.minus(it.toSet())}
}
