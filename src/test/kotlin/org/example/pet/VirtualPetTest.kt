package org.example.pet

import kotlin.test.Ignore
import kotlin.test.assertEquals
import kotlin.test.Test

class VirtualPetTest {

    @Test
    fun starts_with_a_name_and_zero_hunger() {
        val pet = VirtualPet(name = "Fido")

        assertEquals("Fido", pet.name)
        assertEquals(0, pet.hunger)
    }

    @Test
    fun feeding_reduces_hunger_by_five() {
        val pet = VirtualPet(name = "Fido")
        repeat(8) {
            pet.tick()
        }

        pet.feed()

        assertEquals(3, pet.hunger)
    }

    @Test
    fun feeding_does_not_reduce_hunger_below_zero() {
        val pet = VirtualPet(name = "Fido")
        repeat(3) {
            pet.tick()
        }

        pet.feed()

        assertEquals(0, pet.hunger)
    }

    @Test
    fun feeding_does_not_change_happiness_or_energy() {
        val pet = VirtualPet(name = "Fido")
        repeat(10) {
            pet.tick()
        }

        pet.feed()

        assertEquals(90, pet.happiness)
        assertEquals(90, pet.energy)
    }

    @Test
    fun tick_increases_hunger_by_one() {
        val pet = VirtualPet(name = "Fido")

        pet.tick()

        assertEquals(1, pet.hunger)
    }

    @Test
    fun hunger_does_not_exceed_the_maximum() {
        val pet = VirtualPet(name = "Fido")

        repeat(150) {
            pet.tick()
        }

        assertEquals(100, pet.hunger)
    }

    @Test
    fun status_reports_hunger_happiness_and_energy() {
        val pet = VirtualPet(name = "Fido")
        repeat(3) {
            pet.tick()
        }

        assertEquals("Fido: hunger=3/100, happiness=97/100, energy=97/100", pet.status())
    }

    @Test
    fun starts_with_full_happiness_and_energy() {
        val pet = VirtualPet(name = "Fido")

        assertEquals(100, pet.happiness)
        assertEquals(100, pet.energy)
    }

    @Test
    fun tick_reduces_happiness_and_energy_by_one() {
        val pet = VirtualPet(name = "Fido")

        pet.tick()

        assertEquals(99, pet.happiness)
        assertEquals(99, pet.energy)
    }

    @Test
    fun tick_does_not_reduce_happiness_or_energy_below_zero() {
        val pet = VirtualPet(name = "Fido")
        repeat(150) {
            pet.tick()
        }

        assertEquals(0, pet.happiness)
        assertEquals(0, pet.energy)
    }

    @Test
    fun playing_increases_happiness_and_costs_energy() {
        val pet = VirtualPet(name = "Fido")
        repeat(10) {
            pet.tick()
        }

        pet.play()

        assertEquals(95, pet.happiness)
        assertEquals(88, pet.energy)
    }

    @Test
    fun playing_is_blocked_when_energy_is_too_low() {
        val pet = VirtualPet(name = "Fido")
        repeat(99) {
            pet.tick()
        }

        pet.play()

        assertEquals(1, pet.happiness)
        assertEquals(1, pet.energy)
    }

    @Test
    fun playing_is_allowed_when_energy_exactly_matches_the_cost() {
        val pet = VirtualPet(name = "Fido")
        repeat(98) {
            pet.tick()
        }

        pet.play()

        assertEquals(0, pet.energy)
        assertEquals(7, pet.happiness)
    }

    @Test
    fun playing_does_not_raise_happiness_above_the_maximum() {
        val pet = VirtualPet(name = "Fido")
        pet.tick()

        pet.play()

        assertEquals(100, pet.happiness)
        assertEquals(97, pet.energy)
    }

    @Test
    fun playing_does_not_change_hunger() {
        val pet = VirtualPet(name = "Fido")
        repeat(4) {
            pet.tick()
        }

        pet.play()

        assertEquals(4, pet.hunger)
    }

    @Test
    fun sleeping_restores_energy_and_reduces_happiness() {
        val pet = VirtualPet(name = "Fido")
        repeat(10) {
            pet.tick()
        }

        pet.sleep()

        assertEquals(88, pet.happiness)
        assertEquals(95, pet.energy)
    }

    @Test
    fun sleeping_is_blocked_when_happiness_is_too_low() {
        val pet = VirtualPet(name = "Fido")
        repeat(99) {
            pet.tick()
        }

        pet.sleep()

        assertEquals(1, pet.happiness)
        assertEquals(1, pet.energy)
    }

    @Test
    fun sleeping_is_allowed_when_happiness_exactly_matches_the_cost() {
        val pet = VirtualPet(name = "Fido")
        repeat(98) {
            pet.tick()
        }

        pet.sleep()

        assertEquals(0, pet.happiness)
        assertEquals(7, pet.energy)
    }

    @Test
    fun sleeping_does_not_raise_energy_above_the_maximum() {
        val pet = VirtualPet(name = "Fido")
        repeat(3) {
            pet.tick()
        }

        pet.sleep()

        assertEquals(95, pet.happiness)
        assertEquals(100, pet.energy)
    }

    @Test
    fun sleeping_does_not_change_hunger() {
        val pet = VirtualPet(name = "Fido")
        repeat(4) {
            pet.tick()
        }

        pet.sleep()

        assertEquals(4, pet.hunger)
    }

    @Test
    fun mood_is_happy_by_default() {
        val pet = VirtualPet(name = "Fido")

        assertEquals("happy", pet.mood())
    }

    @Test
    fun mood_prefers_tired_when_multiple_rules_match() {
        val pet = VirtualPet(name = "Fido")
        repeat(81) {
            pet.tick()
        }

        assertEquals("tired", pet.mood())
    }

    @Test
    fun mood_is_hungry_when_hunger_is_high_without_higher_priority_matches() {
        val pet = VirtualPet(name = "Fido")
        repeat(81) {
            pet.tick()
        }
        pet.sleep()

        assertEquals("hungry", pet.mood())
    }

    @Test
    fun mood_is_energetic_when_energy_is_high_without_happier_matches() {
        val pet = VirtualPet(name = "Fido")
        repeat(10) {
            pet.sleep()
        }

        assertEquals("energetic", pet.mood())
    }

    @Test
    fun mood_is_content_when_no_other_rule_matches() {
        val pet = VirtualPet(name = "Fido")
        repeat(30) {
            pet.tick()
        }

        assertEquals("content", pet.mood())
    }

    @Test
    fun feeding_returns_the_current_mood() {
        val pet = VirtualPet(name = "Fido")

        assertEquals("happy", pet.feed())
    }

    @Test
    fun playing_returns_the_current_mood_after_a_successful_action() {
        val pet = VirtualPet(name = "Fido")

        assertEquals("happy", pet.play())
    }

    @Ignore
    @Test
    fun playing_returns_a_blocked_message_when_energy_is_too_low() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun sleeping_returns_the_current_mood_after_a_successful_action() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun sleeping_returns_a_blocked_message_when_happiness_is_too_low() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun checking_in_returns_the_current_mood() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun status_reports_mood_and_all_stats() {
        TODO("Test to be implemented in a later commit.")
    }

}
