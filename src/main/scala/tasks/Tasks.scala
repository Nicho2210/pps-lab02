package u02

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