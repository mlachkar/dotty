package scala.reflect

/** A base trait of all Scala enum definitions */
super trait Enum extends Any, Product, Serializable:

  /** A string uniquely identifying a case of an enum */
  def enumLabel: String

  /** A number uniquely identifying a case of an enum */
  def ordinal: Int
