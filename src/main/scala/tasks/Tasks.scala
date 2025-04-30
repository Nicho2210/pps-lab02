package tasks

object Tasks extends App:

  //----------------------TASK 3.a----------------------

  val positiveLambda: Int => String = {
    case x if x >= 0 => "positive"
    case _ => "negative"
  }

  def positiveMethod(x: Int): String = x match {
    case x if x >= 0 => "positive"
    case _ => "negative"
  }

  //----------------------TASK 3.b----------------------

  private val negLambda: (String => Boolean) => String => Boolean = predicate => s => !predicate(s)
  private def negMethod(predicate: String => Boolean) = (s: String) => !predicate(s)

  private val empty: String => Boolean = _ == ""

  val notEmptyLamba = negLambda(empty)
  val notEmptyMethod = negMethod(empty)

  //----------------------TASK 3.c----------------------
  private def negGeneric[X](predicate: X => Boolean): X => Boolean = x => !predicate(x)
  
  //For testing
  val notEmptyGeneric = negGeneric(empty)
  
  private val isPositive: Int => Boolean = _ > 0
  val isNotPositive = negGeneric(isPositive)
  
  private val isTrue: Boolean => Boolean = identity
  val isFalse = negGeneric(isTrue)
  
  //----------------------TASK 4----------------------

  //curried val
  val p1: Double => Double => Double => Boolean =
    x => y => z => (x <= y) && (y == z)

  //not curried val
  val p2: (Double, Double, Double) => Boolean =
    (x, y, z) => (x <= y) && (y == z)

  //curried def
  def p3(x: Double)(y: Double)(z: Double): Boolean =
    (x <= y) && (y == z)

  //not curried def
  def p4(x: Double, y: Double, z: Double): Boolean =
    (x <= y) && (y == z)

  //----------------------TASK 5----------------------
  println()
  println("Task 5")
  println()

  private def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  private def compose_generic[A, B, C](f: A => B, g: C => A): C => B = x => f(g(x))

  private val n = 5

  println(s"f(g($n)) = ${compose(_ - 1, _ * 2)(n)}")
  println(s"f(g($n)) = ${compose_generic[Int, Int, Int](_ - 1, _ * 2)(n)}")

  //----------------------TASK 6----------------------
  println()
  println("Task 6")
  println()

  private def composeThree[A,B,C,D](f: C => D, g: B => C, h: A => B): A => D = x => compose_generic(f, compose_generic(g, h))(x)

  println(composeThree[Int, Int, String, String](_ + "!", _.toString, _ * 2)(3))

  //----------------------TASK 7----------------------
  println()
  println("Task 7")
  println()

  private def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  println("Recursive:")
  println(s"2^0 = ${power(2, 0)}")
  println(s"2^10 = ${power(2, 10)}")
  println()

  private def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def _pow(base: Double, exp: Int, acc: Double): Double = exp match
      case 0 => acc
      case _ if exp > 0 => _pow(base, exp - 1, base * acc)

    _pow(base, exponent, 1)

  println("Tail recursion:")
  println(s"2^0 = ${powerTail(2, 0)}")
  println(s"2^10 = ${powerTail(2, 10)}")

  //----------------------TASK 8----------------------
  println()
  println("Task 8")
  println()

  private def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def _reverse(n: Int, res: Int): Int = n match {
      case n if n / 10 < 1 => res * 10 + n
      case _ => _reverse(n / 10, res * 10 + n % 10)
    }
    _reverse(n, 0)

  println(s"12345 => ${reverseNumber(12345)}")

  //----------------------TASK 9----------------------
  println()
  println("Task 9")
  println()