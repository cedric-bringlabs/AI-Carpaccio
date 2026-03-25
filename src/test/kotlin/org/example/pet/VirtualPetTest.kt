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
    fun status_reports_name_and_hunger() {
        val pet = VirtualPet(name = "Fido")
        repeat(3) {
            pet.tick()
        }

        assertEquals("Fido: hunger=3/100", pet.status())
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

    @Ignore
    @Test
    fun playing_is_blocked_when_energy_is_too_low() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun playing_does_not_raise_happiness_above_the_maximum() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun sleeping_restores_energy_and_reduces_happiness() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun sleeping_is_blocked_when_happiness_is_too_low() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun sleeping_does_not_raise_energy_above_the_maximum() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun status_reports_hunger_happiness_and_energy() {
        TODO("Test to be implemented in a later commit.")
    }
}
