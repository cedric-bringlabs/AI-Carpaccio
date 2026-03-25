package org.example.pet

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
}
