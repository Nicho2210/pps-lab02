package tasks

import org.junit.*
import org.junit.Assert.*

class tasksTest:
  import Tasks.*

  @Test def task_3a(): Unit =
    assertEquals("positive", positiveLambda(10))
    assertEquals("positive", positiveLambda(0))
    assertEquals("negative", positiveLambda(-10))
    assertEquals("positive", positiveMethod(10))
    assertEquals("positive", positiveMethod(0))
    assertEquals("negative", positiveMethod(-10))

  @Test def task_3b(): Unit =
    assertTrue(notEmptyLamba("foo"))
    assertFalse(notEmptyLamba(""))
    assertTrue(notEmptyMethod("foo"))
    assertFalse(notEmptyMethod(""))

  @Test def task_3c(): Unit =
    assertTrue(notEmptyGeneric("foo"))
    assertFalse(notEmptyGeneric(""))
    assertTrue(isNotPositive(-10))
    assertTrue(isNotPositive(0))
    assertFalse(isNotPositive(10))
    assertTrue(isFalse(false))
    assertFalse(isFalse(true))
