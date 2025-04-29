package tasks

object Tasks extends App:

  //----------------------TASK 3.a----------------------
  println("Task 3.a")
  println()

  //function literal
  private val positive_lambda: Int => String = {
    case x if x >= 0 => "positive"
    case _ => "negative"
  }

  //method syntax
  private def positive_method(x: Int): String = x match {
    case x if x >= 0 => "positive"
    case _ => "negative"
  }

  //prints
  private val n_positive = 5
  private val n_negative = -5
  println("Lambda:")
  println(s"$n_positive: ${positive_lambda(n_positive)}")
  println(s"$n_negative: ${positive_lambda(n_negative)}")
  println()
  println("Method:")
  println(s"$n_positive: ${positive_method(n_positive)}")
  println(s"$n_negative: ${positive_method(n_negative)}")

  //----------------------TASK 3.b----------------------
  println()
  println("Task 3.b")
  println()

  private val neg_lambda: (String => Boolean) => String => Boolean = predicate => s => !predicate(s)
  private def neg_method(predicate: String => Boolean) = (s: String) => !predicate(s)

  private val empty: String => Boolean = _ == ""
  private val notEmptyLamba = neg_lambda(empty)
  private val notEmptyMethod = neg_method(empty)

  private val foo = "foo"

  println(s": ${empty("")}")
  println(s"$foo: ${empty(foo)}")
  println()
  println("Lambda:")
  println(s": ${notEmptyLamba("")}")
  println(s"$foo: ${notEmptyLamba(foo)}")
  println()
  println("Method:")
  println(s": ${notEmptyMethod("")}")
  println(s"$foo: ${notEmptyMethod(foo)}")

  //----------------------TASK 3.c----------------------
  println()
  println("Task 3.c")
  println()

  private def neg_generic[X](predicate: X => Boolean): X => Boolean = x => !predicate(x)

  private val notEmptyGeneric = neg_generic(empty)

  println("Generic:")
  println(s": ${notEmptyGeneric("")}")
  println(s"$foo: ${notEmptyGeneric(foo)}")

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
