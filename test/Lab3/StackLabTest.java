package Lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackLabTest
{
    @Test
    void isBalancedTest()
    {
        assertTrue(StackLab.isBalanced("(2+[5+7]+1)"));
        assertTrue(StackLab.isBalanced("(2+1)"));
        assertTrue(StackLab.isBalanced("[2+1]"));
        assertTrue(StackLab.isBalanced("{2+1}"));
        assertTrue(StackLab.isBalanced("<2+1>"));
        assertTrue(StackLab.isBalanced("<2+[6+3]+1>"));
        assertTrue(StackLab.isBalanced("<2+<4+5>+1>"));
        assertTrue(StackLab.isBalanced("<2+{5-6}+1>"));
        assertTrue(StackLab.isBalanced("<2+(3*[5+{6/4}+5]+4)+1>"));

        assertTrue(StackLab.isBalanced("3+2"));
    }

    @Test
    void isBalancedTestFalse(){
        assertFalse(StackLab.isBalanced("(3+2]"));
        assertFalse(StackLab.isBalanced("(3+2]>"));
        assertFalse(StackLab.isBalanced("(<3+2]"));
        assertFalse(StackLab.isBalanced("({3+2)]"));
        assertFalse(StackLab.isBalanced("<2+(3*[5+{6/4+5]+4)+1>"));
    }
}