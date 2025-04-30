package tasks

object Tasks extends App:

  //----------------------TASK 3.a----------------------

  // val assigned to function literal
  val positiveLambda: Int => String = {
    case x if x >= 0 => "positive"
    case _ => "negative"
  }

  // method syntax
  def positiveMethod(x: Int): String = x match {
    case x if x >= 0 => "positive"
    case _ => "negative"
  }

  //----------------------TASK 3.b----------------------

  private val empty: String => Boolean = _ == ""

  // val lambda
  private val negLambda: (String => Boolean) => String => Boolean =
    predicate => s => !predicate(s)

  val notEmptyLamba = negLambda(empty)

  // method syntax
  private def negMethod(predicate: String => Boolean) =
    (s: String) => !predicate(s)

  val notEmptyMethod = negMethod(empty)

  //----------------------TASK 3.c----------------------
  private def negGeneric[X](predicate: X => Boolean): X => Boolean = x => !predicate(x)

  // for testing
  val notEmptyGeneric = negGeneric(empty)

  private val isPositive: Int => Boolean = _ > 0
  val isNotPositive = negGeneric(isPositive)

  private val isTrue: Boolean => Boolean = identity
  val isFalse = negGeneric(isTrue)

  //----------------------TASK 4----------------------

  // curried val
  val p1: Double => Double => Double => Boolean =
    x => y => z => (x <= y) && (y == z)

  // not curried val
  val p2: (Double, Double, Double) => Boolean =
    (x, y, z) => (x <= y) && (y == z)

  // curried def
  def p3(x: Double)(y: Double)(z: Double): Boolean =
    (x <= y) && (y == z)

  // not curried def
  def p4(x: Double, y: Double, z: Double): Boolean =
    (x <= y) && (y == z)

  //----------------------TASK 5----------------------

  def compose2Int(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  def compose2Generic[A, B, C](f: B => C, g: A => B): A => C =
    x => f(g(x))

  //----------------------TASK 6----------------------

  def compose3Generic[A, B, C, D](f: C => D, g: B => C, h: A => B): A => D = x => compose2Generic(f, compose2Generic(g, h))(x)

  //----------------------TASK 7----------------------

  def powerRecursive(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * powerRecursive(base, exponent - 1)

  def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def _pow(base: Double, exp: Int, acc: Double): Double = exp match
      case 0 => acc
      case _ if exp > 0 => _pow(base, exp - 1, base * acc)

    _pow(base, exponent, 1)

  //----------------------TASK 8----------------------

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def _reverse(n: Int, res: Int): Int = n match {
      case n if n / 10 < 1 => res * 10 + n
      case _ => _reverse(n / 10, res * 10 + n % 10)
    }
    _reverse(n, 0)

  //----------------------TASK 9----------------------
  println()
  println("Task 9")
  println()