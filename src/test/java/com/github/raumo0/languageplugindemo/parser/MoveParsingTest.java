package com.github.raumo0.languageplugindemo.parser;

import com.intellij.testFramework.ParsingTestCase;

public class MoveParsingTest extends ParsingTestCase {

  public MoveParsingTest() {
    super("", "move", new MoveParserDefinition());
  }

  public void testParsingTestData() {
    doTest(true);
  }

  /**
   * @return path to test data file directory relative to root of this module.
   */
  @Override
  protected String getTestDataPath() {
    return "src/test/testData";
  }

  @Override
  protected boolean includeRanges() {
    return true;
  }

}
