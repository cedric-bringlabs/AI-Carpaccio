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
    var happiness: Int = MAX_STAT
        private set

    /**
     * The pet's current energy level.
     */
    var energy: Int = MAX_STAT
        private set

    /**
     * Advances the pet by a single world tick, making it hungrier.
     */
    fun tick() {
        hunger = increaseStat(hunger, TICK_HUNGER_INCREASE)
        happiness = decreaseStat(happiness, TICK_HAPPINESS_DECREASE)
        energy = decreaseStat(energy, TICK_ENERGY_DECREASE)
    }

    /**
     * Feeds the pet, reducing hunger without going below zero.
     */
    fun feed(): String {
        hunger = decreaseStat(hunger, FEED_HUNGER_REDUCTION)
        return mood()
    }

    /**
     * Plays with the pet, spending energy to improve its mood.
     */
    fun play(): String {
        if (energy < PLAY_ENERGY_COST) return mood()

        energy = decreaseStat(energy, PLAY_ENERGY_COST)
        happiness = increaseStat(happiness, PLAY_HAPPINESS_GAIN)
        return mood()
    }

    /**
     * Lets the pet sleep, restoring energy while lowering happiness slightly.
     */
    fun sleep(): String {
        if (happiness < SLEEP_HAPPINESS_COST) return mood()

        energy = increaseStat(energy, SLEEP_ENERGY_GAIN)
        happiness = decreaseStat(happiness, SLEEP_HAPPINESS_COST)
        return mood()
    }

    fun mood(): String = when {
        energy < 20 -> "tired"
        hunger > 80 -> "hungry"
        happiness > 80 -> "happy"
        energy > 80 -> "energetic"
        else -> "content"
    }

    /**
     * Returns a concise snapshot of the pet's current state.
     */
    fun status(): String =
        "$name: hunger=$hunger/$MAX_STAT, happiness=$happiness/$MAX_STAT, energy=$energy/$MAX_STAT"

    companion object {
        const val MAX_STAT: Int = 100

        private const val FEED_HUNGER_REDUCTION: Int = 5
        private const val PLAY_ENERGY_COST: Int = 2
        private const val PLAY_HAPPINESS_GAIN: Int = 5
        private const val SLEEP_ENERGY_GAIN: Int = 5
        private const val SLEEP_HAPPINESS_COST: Int = 2
        private const val TICK_ENERGY_DECREASE: Int = 1
        private const val TICK_HAPPINESS_DECREASE: Int = 1
        private const val TICK_HUNGER_INCREASE: Int = 1
    }

    private fun increaseStat(currentValue: Int, amount: Int): Int =
        (currentValue + amount).coerceAtMost(MAX_STAT)

    private fun decreaseStat(currentValue: Int, amount: Int): Int =
        (currentValue - amount).coerceAtLeast(0)
}
