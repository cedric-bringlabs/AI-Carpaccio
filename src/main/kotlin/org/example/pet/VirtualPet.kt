package org.example.pet

/**
 * Represents a virtual pet with a name and bounded stats.
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
     * The pet's current happiness level.
     */
    var happiness: Int = MAX_HUNGER
        private set

    /**
     * The pet's current energy level.
     */
    var energy: Int = MAX_HUNGER
        private set

    /**
     * Advances the pet by a single world tick, making it hungrier.
     */
    fun tick() {
        hunger = (hunger + TICK_HUNGER_INCREASE).coerceAtMost(MAX_HUNGER)
        happiness = (happiness - TICK_HAPPINESS_DECREASE).coerceAtLeast(0)
        energy = (energy - TICK_ENERGY_DECREASE).coerceAtLeast(0)
    }

    /**
     * Feeds the pet, reducing hunger without going below zero.
     */
    fun feed() {
        hunger = (hunger - FEED_HUNGER_REDUCTION).coerceAtLeast(0)
    }

    /**
     * Returns a concise snapshot of the pet's current state.
     */
    fun status(): String = "$name: hunger=$hunger/$MAX_HUNGER"

    companion object {
        const val MAX_HUNGER: Int = 100

        private const val FEED_HUNGER_REDUCTION: Int = 5
        private const val TICK_ENERGY_DECREASE: Int = 1
        private const val TICK_HAPPINESS_DECREASE: Int = 1
        private const val TICK_HUNGER_INCREASE: Int = 1
    }
}
