package org.example.pet

/**
 * Represents a virtual pet with a name and a bounded hunger level.
 */
class VirtualPet(
    val name: String,
) {
    /**
     * The pet's current hunger level.
     */
    var hunger: Int = 0
        private set

    /**
     * Advances the pet by a single world tick, making it hungrier.
     */
    fun tick() {
        hunger = (hunger + TICK_HUNGER_INCREASE).coerceAtMost(MAX_HUNGER)
    }

    companion object {
        const val MAX_HUNGER: Int = 100

        private const val TICK_HUNGER_INCREASE: Int = 1
    }
}
