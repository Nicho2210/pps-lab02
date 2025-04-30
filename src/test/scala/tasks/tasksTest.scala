package tasks

import org.junit.*
import org.junit.Assert.*

class tasksTest:
  import Tasks.*

  @Test def task_3a(): Unit =
    assertEquals("positive", positive_lambda(10))
    assertEquals("positive", positive_lambda(0))
    assertEquals("negative", positive_lambda(-10))
    assertEquals("positive", positive_method(10))
    assertEquals("positive", positive_method(0))
    assertEquals("negative", positive_method(-10))