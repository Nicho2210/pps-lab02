package tasks

import org.junit.*
import org.junit.Assert.*

class tasksTest:
  import Tasks.*

  @Test def task_3a(): Unit =
    // val assigned to function literal
    assertEquals("positive", positiveLambda(10))
    assertEquals("positive", positiveLambda(0))
    assertEquals("negative", positiveLambda(-10))
    // method syntax
    assertEquals("positive", positiveMethod(10))
    assertEquals("positive", positiveMethod(0))
    assertEquals("negative", positiveMethod(-10))

  @Test def task_3b(): Unit =
    // val lambda
    assertTrue(notEmptyLamba("foo"))
    assertFalse(notEmptyLamba(""))
    // method syntax
    assertTrue(notEmptyMethod("foo"))
    assertFalse(notEmptyMethod(""))

  @Test def task_3c(): Unit =
    //String => Boolean
    assertTrue(notEmptyGeneric("foo"))
    assertFalse(notEmptyGeneric(""))
    // Int => Boolean
    assertTrue(isNotPositive(-10))
    assertTrue(isNotPositive(0))
    assertFalse(isNotPositive(10))
    // Boolean => Boolean
    assertTrue(isFalse(false))
    assertFalse(isFalse(true))

  @Test def task_4(): Unit =
    // curried val
    assertTrue(p1(2.0)(2.7)(2.7))
    assertFalse(p1(8.1)(2.4)(2.4))
    assertFalse(p1(6.0)(8.2)(3.9))
    // not curried val
    assertTrue(p2(2.0, 2.7, 2.7))
    assertFalse(p2(8.1, 2.4, 2.4))
    assertFalse(p2(6.0, 8.2, 3.9))
    // curried def
    assertTrue(p3(2.0)(2.7)(2.7))
    assertFalse(p3(8.1)(2.4)(2.4))
    assertFalse(p3(6.0)(8.2)(3.9))
    // not curried def
    assertTrue(p4(2.0, 2.7, 2.7))
    assertFalse(p4(8.1, 2.4, 2.4))
    assertFalse(p4(6.0, 8.2, 3.9))

  @Test def task_5(): Unit =
    assertEquals(9, compose2Int(_ - 1, _ * 2)(5))
    assertEquals(9, compose2Generic[Int, Int, Int](_ - 1, _ * 2)(5))
    assertEquals("T", compose2Generic[Int, Boolean, String](if _ then "T" else "F", _ > 2)(5))
    assertEquals("F", compose2Generic[Int, Boolean, String](if _ then "T" else "F", _ > 2)(1))

  @Test def task_6(): Unit =
    assertEquals("6!", compose3Generic[Int, Int, String, String](_ + "!", _.toString, _ * 2)(3))

  @Test def task_7(): Unit =
    // power without tail rec
    assertEquals(1, powerRecursive(7, 0), 0.000)
    assertEquals(1024, powerRecursive(2, 10), 0.000)
    assertEquals(10, powerRecursive(10, 1), 0.000)
    //power with tail rec
    assertEquals(1, powerTail(7, 0), 0.000)
    assertEquals(1024, powerTail(2, 10), 0.000)
    assertEquals(10, powerTail(10, 1), 0.000)

  @Test def task_8(): Unit =
    assertEquals(987654321, reverseNumber(123456789))
    assertEquals(1, reverseNumber(100000))

  @Test def task_9(): Unit =
    // simple expression
    val expr1 = Expr.Literal(7)
    assertEquals(7, Expr.evaluate(expr1))
    assertEquals("7", Expr.show(expr1))
    // addition
    val expr2 = Expr.Add(Expr.Literal(4), Expr.Literal(3))
    assertEquals(7, Expr.evaluate(expr2))
    assertEquals("(4 + 3)", Expr.show(expr2))
    // multiplication
    val expr3 = Expr.Multiply(Expr.Literal(5), Expr.Literal(6))
    assertEquals(30, Expr.evaluate(expr3))
    assertEquals("(5 * 6)", Expr.show(expr3))
    // complicated expression
    val expr4 = Expr.Multiply(Expr.Add(Expr.Literal(3), Expr.Literal(2)), Expr.Literal(4))
    assertEquals(20, Expr.evaluate(expr4))
    assertEquals("((3 + 2) * 4)", Expr.show(expr4))
    // nested expression
    val expr5 = Expr.Add(
      Expr.Multiply(Expr.Literal(2), Expr.Literal(3)),
      Expr.Add(Expr.Literal(1), Expr.Literal(4))
    )
    assertEquals(11, Expr.evaluate(expr5))
    assertEquals("((2 * 3) + (1 + 4))", Expr.show(expr5))