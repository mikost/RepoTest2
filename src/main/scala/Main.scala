package com.mikko.repotest2

object Main {
  def main(args: Array[String]) {
    val puzzle = new SliderPuzzle(4,4)
    moveAndPrint(puzzle, 15)
    moveAndPrint(puzzle, 11)
    moveAndPrint(puzzle, 12)
  }

  def moveAndPrint(puzzle: SliderPuzzle, sliderNum: Int) {
    puzzle move sliderNum
    println("Move slider "+ sliderNum +":")
    println((puzzle toString) split "\n"
                              mkString("  ", "\n  ", ""))
  }
}

object Direction extends Enumeration {
  type Direction = Value
  val UP, RIGHT, DOWN, LEFT = Value
}
import Direction._

class Slot(frame: SliderPuzzle) {
  var slider: Option[Slider] = None
  lazy val slotUp    = frame.slot(UP,    this)
  lazy val slotRight = frame.slot(RIGHT, this)
  lazy val slotDown  = frame.slot(DOWN,  this)
  lazy val slotLeft  = frame.slot(LEFT,  this)

  def emptyNeighbor: Option[Slot] = {
    val maybeNeighbors = List(slotUp, slotRight, slotDown, slotLeft)
    val someNeighbors = maybeNeighbors.filter(_.isInstanceOf[Some[Slot]])
    val neighbors = someNeighbors.map(_.get)
    neighbors.find(_.isEmpty)
  }

  def isEmpty = slider == None
}

class Slider(var slot: Slot, val sliderNum: Int) {

  def move: Unit = {
    slot.emptyNeighbor match {
      case Some(emptySlot) => slot.slider = None; slot = emptySlot; slot.slider = Some(this);
      case None => Unit
    }
  }
}

class SliderPuzzle(nRows: Int, nCols: Int) {
  val slots = Array.ofDim[Slot](nCols, nRows)

  for (row <- 0 until nRows;
       col <- 0 until nCols) {
    val theSlot = new Slot(frame = this)
    if (row < nRows-1 || col < nCols-1) {
      val sliderNum = 1 + row * nCols + col
      theSlot.slider = Some(new Slider(theSlot, sliderNum))
    }
    slots(col)(row) = theSlot
  }

  def move(sliderNum: Int):Unit = {
    findSlider.move

    def findSlider:Slider = {
      findSlot(
	_.slider match {
	  case Some(slider) => slider.sliderNum == sliderNum
	  case None => false
	}) match {
	  case Some(slot) => slot.slider.get
	  case None => throw new IllegalArgumentException
	}
    }

    def findSlot(p: Slot => Boolean):Option[Slot] = {
      for (row <-0 until nRows;
	   col <- 0 until nCols;
	   theSlot = slots(col)(row)) {
	if (p(theSlot))
	  return Some(theSlot)
      }
      None
    }
  }

  override def toString = {
    val sliderStrings =
      for (row <- 0 until nRows;
	   col <- 0 until nCols)
      yield {
	val nl = if (col == nCols - 1) "\n" else ""
	slots(col)(row).slider match {
	  case Some(slider) => String.format("<%2d>%s", slider.sliderNum.asInstanceOf[AnyRef], nl)
	  case None => String.format("<  >%s", nl)
	} 
      }
    sliderStrings mkString ""
  }

  def slot(dir: Direction, slot: Slot):Option[Slot] = {
    val (col, row) = find(slot)

    dir match {
      case UP    if (row > 0)         => Some(slots(col  )(row-1))
      case RIGHT if (col < nCols -1)  => Some(slots(col+1)(row  ))
      case DOWN  if (row < nRows-1)   => Some(slots(col  )(row+1))
      case LEFT  if (col > 0)         => Some(slots(col-1)(row  ))
      case _ => None
    }
  }

  private def find(slot: Slot):(Int,Int) = {
    for (row <- 0 until nRows;
	 col <- 0 until nCols)
      if (slots(col)(row) eq slot)
	return (col, row)
    throw new IllegalArgumentException
  }
}
