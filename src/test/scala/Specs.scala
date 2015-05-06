package com.mikko.sliderpuzzle

import org.specs._

class Specs extends Specification {

  "Main.add" should {
    "add the supplied integers" in {
      Main.add(2,3) mustEqual 5
    }
  }

}
