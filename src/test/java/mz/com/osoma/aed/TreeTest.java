/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.osoma.aed;
import mz.com.osoma.aed.tree.Node;
import mz.com.osoma.aed.tree.Tree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



import static org.junit.Assert.*;

/**
 *
 * @author feler
 */
public class TreeTest {
    
    public TreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class Tree.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int key = 50;
        Tree instance = new Tree();
        
        instance.insert(50, 1.5);
        instance.insert(25, 1.2);
        instance.insert(75, 1.7);
        instance.insert(12, 1.5);
        instance.insert(37, 1.2);
        instance.insert(43, 1.7);
        instance.insert(30, 1.5);
        instance.insert(33, 1.2);
        instance.insert(87, 1.7);
        instance.insert(93, 1.5);
        instance.insert(97, 1.5);
        
        
        Node expResult = new Node(50, 1.5);
        
        Node result = instance.find(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of insert method, of class Tree.
//     */
//    @org.junit.Test
//    public void testInsert() {
//        System.out.println("insert");
//        int id = 0;
//        double dd = 0.0;
//        Tree instance = new Tree();
//        instance.insert(id, dd);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of traverse method, of class Tree.
//     */
//    @org.junit.Test
//    public void testTraverse() {
//        System.out.println("traverse");
//        int traverseType = 0;
//        Tree instance = new Tree();
//        instance.traverse(traverseType);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of inOrder method, of class Tree.
//     */
//    @org.junit.Test
//    public void testInOrder() {
//        System.out.println("inOrder");
//        Node localRoot = null;
//        Tree instance = new Tree();
//        instance.inOrder(localRoot);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of preOrder method, of class Tree.
//     */
//    @org.junit.Test
//    public void testPreOrder() {
//        System.out.println("preOrder");
//        Node localRoot = null;
//        Tree instance = new Tree();
//        instance.preOrder(localRoot);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of postOrder method, of class Tree.
//     */
//    @org.junit.Test
//    public void testPostOrder() {
//        System.out.println("postOrder");
//        Node localRoot = null;
//        Tree instance = new Tree();
//        instance.postOrder(localRoot);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class Tree.
//     */
//    @org.junit.Test
//    public void testDelete() {
//        System.out.println("delete");
//        int key = 0;
//        Tree instance = new Tree();
//        boolean expResult = false;
//        boolean result = instance.delete(key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Tree.
//     */
//    @org.junit.Test
//    public void testToString() {
//        System.out.println("toString");
//        Tree instance = new Tree();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class Tree.
//     */
//    @org.junit.Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Tree.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
