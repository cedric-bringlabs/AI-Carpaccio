package org.example.pet

import kotlin.test.Ignore
import kotlin.test.Test

class VirtualPetTest {

    @Test
    fun starts_with_a_name_and_zero_hunger() {
        val pet = VirtualPet(name = "Fido")

        kotlin.test.assertEquals("Fido", pet.name)
        kotlin.test.assertEquals(0, pet.hunger)
    }

    @Ignore
    @Test
    fun feeding_reduces_hunger_by_five() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun feeding_does_not_reduce_hunger_below_zero() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun tick_increases_hunger_by_one() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun hunger_does_not_exceed_the_maximum() {
        TODO("Test to be implemented in a later commit.")
    }

    @Ignore
    @Test
    fun status_reports_name_and_hunger() {
        TODO("Test to be implemented in a later commit.")
    }
}
