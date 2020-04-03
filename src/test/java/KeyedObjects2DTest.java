import org.jfree.data.KeyedObjects2D;

import org.jfree.data.UnknownKeyException;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class KeyedObjects2DTest {

    @Mock
    Comparable rowKey1 = "1";
    Comparable rowKey2 = "2";
    Comparable rowKey3 = "3";
    Comparable columnKey1 = "1";
    Comparable columnKey2 = "2";
    Comparable columnKey3 = "3";
    Comparable rowKeyFalse="hello";
    Comparable columnKeyFalse = "Hi";
    Comparable rowKeyNull=null;
    Comparable columnKeyNull = null;
    Comparable rowKeyAdd = "row1";
    Comparable columnKeyAdd = "column1";
    Object obj1 = null;
    Object obj2 = 1;
    Object obj3 = 2;

    @Test
    public void testConstructor() {
        //arrage
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        //act
        int count = keyedObjects2D.getRowCount();
        //assert
        assertEquals(0,count);
    }

    @Test
    public void testGetRowCountEmpty() {
        //arrange in before
        KeyedObjects2D keyedObject = new KeyedObjects2D();
        //act
        int count = keyedObject.getRowCount();
        //assert
        assertEquals(0,count);
    }

    @Test
    public void testGetColumnCountEmpty() {
        //arrange
        KeyedObjects2D keyedObject = new KeyedObjects2D();
        //act
        int count = keyedObject.getColumnCount();
        //assert
        assertEquals(0,count);
    }

    @Test
    public void testGetRowCountOne() {
        //arrange
        KeyedObjects2D keyedObjects2D = Mockito.mock(KeyedObjects2D.class);
        when(keyedObjects2D.getRowCount()).thenReturn(1);
        int count = keyedObjects2D.getRowCount();
        assertEquals(1,count);
        verify(keyedObjects2D,times(1)).getRowCount();
    }

    @Test
    public void testGetRowCountTen() {
        //arrange
        KeyedObjects2D keyedObjects2D = mock(KeyedObjects2D.class);
        //act
        when(keyedObjects2D.getRowCount()).thenReturn(10);
        int count = keyedObjects2D.getRowCount();
        assertEquals(10,count);
        verify(keyedObjects2D,times(1)).getRowCount();
    }

    @Test
    public void testGetColumnCountOne() {
        //arrange
        KeyedObjects2D keyedObjects2D = mock(KeyedObjects2D.class);
        //act
        when(keyedObjects2D.getColumnCount()).thenReturn(1);
        int count = keyedObjects2D.getColumnCount();
        //assert
        assertEquals(1,count);
        verify(keyedObjects2D,times(1)).getColumnCount();
    }
    @Test
    public void testGetColumnCountTen() {
        //arrange
        KeyedObjects2D keyedObjects2D = mock(KeyedObjects2D.class);
        //act
        when(keyedObjects2D.getColumnCount()).thenReturn(10);
        int count = keyedObjects2D.getColumnCount();
        //assert
        assertEquals(10,count);
        verify(keyedObjects2D,times(1)).getColumnCount();
    }

    @Test
    public void testGetObjectEmptyList() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        //act
        Object obj = keyedObjects2D.getObject(0,0);
        //assert
    }

    @Test
    public void testGetObjectWithIndexNullObjectIntegration() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        //act
        Object obj = keyedObjects2D.getObject(0,0);
        //assert
        assertNull(obj);
    }

    @Test
    public void testGetObjectWithIndexNotNullIntegration() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        //act
        Object obj = keyedObjects2D.getObject(1,1);
        //assert
        assertEquals(obj,objB);
    }
    @Test
    public void testGetObjectWithIndexNullIntegration() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Object objC = 4;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        keyedObjects2D.addObject(objC,rowKeyA,columnKeyB);
        //act
        Object obj = keyedObjects2D.getObject(1,0);
        //assert
        assertNull(obj);
    }

    @Test
    public void testGetRowKeyFalseIndex() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        //act
        Comparable rowKey = keyedObjects2D.getRowKey(0);
        //assert
    }
    
    @Test
    public void testGetRowKeyIntegrationHappy() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        //act
        Comparable rowKey = keyedObjects2D.getRowKey(0);
        //assert
        assertEquals(rowKey,rowKeyA);
    }

    @Test
    public void testGetRowKeyRowNotFoundIntegration() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        //act
        Comparable rowKey = keyedObjects2D.getRowKey(-1);
        //assert
        assertNull(rowKey);
    }


    @Test
    public void testGetRowIndexHappyIntegration() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        //act
        int index = keyedObjects2D.getRowIndex(rowKeyA);
        //assert
        assertEquals(0,index);
    }

    @Test
    public void testGetRowIndexFlaseKeyIntegration() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        Comparable falseRowKey = "5";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        int index = keyedObjects2D.getRowIndex(falseRowKey);
        //assert
        assertEquals(-1,index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetRowIndexInt3() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        int index = keyedObjects2D.getRowIndex(null);

    }

    @Test
    public void testGetRowKeysInt1() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        List listRowKeys = new ArrayList();
        listRowKeys.add(rowKeyA);
        listRowKeys.add(rowKeyB);
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        //act
        List listOfRowKeys = keyedObjects2D.getRowKeys();
        //assert
        assertEquals(listOfRowKeys,listRowKeys);
    }

    @Test
    public void testGetRowKeys2() {
        //arrange
        List list = new ArrayList();
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        //act
        List listOfRowKeys = keyedObjects2D.getRowKeys();
        //assert
        assertEquals(listOfRowKeys,list);
    }

    @Test
    public void testGetColumnKeyInt1() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "1";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Comparable columnKey = keyedObjects2D.getColumnKey(0);
        //assert
        assertEquals(columnKey,columnKey1);
    }
    @Test
    public void testGetColumnKeyInt2() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "1";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Comparable columnKey = keyedObjects2D.getColumnKey(4);
        //assert
        assertNull(columnKey);
    }


    @Test
    public void testGetColumnIndexInt1() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "1";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        int index = keyedObjects2D.getColumnIndex(columnKey1);
        //assert
        assertEquals(0,index);
    }

    @Test
    public void testGetColumnIndexInt2() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "1";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        int index = keyedObjects2D.getColumnIndex(columnKeyFalse);
        //assert
        assertEquals(-1,index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetColumnIndexInt3() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "1";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        int index = keyedObjects2D.getColumnIndex(null);

    }

    @Test
    public void testGetColumnKeysInt1() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object objA = null;
        Object objB = 1;
        Comparable rowKeyA = "1";
        Comparable rowKeyB = "2";
        Comparable columnKeyA = "1";
        Comparable columnKeyB = "2";
        List listColumnKeys = new ArrayList();
        listColumnKeys.add(columnKeyA);
        listColumnKeys.add(columnKeyB);
        keyedObjects2D.addObject(objA,rowKeyA,columnKeyA);
        keyedObjects2D.addObject(objB,rowKeyB,columnKeyB);
        //act
        List columnKeys = keyedObjects2D.getColumnKeys();
        //assert
        assertEquals(columnKeys,listColumnKeys);
    }

    @Test
    public void testGetColumnKeys2() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        List list = new ArrayList();
        //act
        List columnKeys = keyedObjects2D.getColumnKeys();
        //assert
        assertEquals(columnKeys,list);
    }

    @Test
    public void testGetObjectCompInt1() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "1";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object = keyedObjects2D.getObject(rowKey1,columnKey1);
        //assert
        assertNull(object);
    }
    @Test
    public void testGetObjectCompInt2() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "2";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object =keyedObjects2D.getObject(rowKey2,columnKey2);
        //assert
        assertEquals(object,obj2);
    }

    @Test(expected = UnknownKeyException.class)
    public void testGetObjectCompInt3() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "2";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object =keyedObjects2D.getObject(rowKeyFalse,columnKey2);
    }

    @Test(expected = UnknownKeyException.class)
    public void testGetObjectCompInt4() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "2";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object =keyedObjects2D.getObject(rowKey2,columnKeyFalse);
    }

    @Test(expected = UnknownKeyException.class)
    public void testGetObjectCompInt5() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "2";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object =keyedObjects2D.getObject(rowKeyFalse,columnKeyFalse);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetObjectCompInt6() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "2";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object =keyedObjects2D.getObject(rowKeyNull,columnKey2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetObjectCompInt7() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "2";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object =keyedObjects2D.getObject(rowKey2,columnKeyNull);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetObjectCompInt8() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Object obj1 = null;
        Object obj2 = 1;
        Comparable rowKey1 = "1";
        Comparable rowKey2 = "2";
        Comparable columnKey1 = "2";
        Comparable columnKey2 = "2";
        keyedObjects2D.addObject(obj1,rowKey1,columnKey1);
        keyedObjects2D.addObject(obj2,rowKey2,columnKey2);
        //act
        Object object =keyedObjects2D.getObject(rowKeyNull,columnKeyNull);
    }

    @Test
    public void testAddObject1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.addObject(obj1,rowKeyAdd,columnKeyAdd);
        when(keyedObjects2D.getObject(0,0)).thenReturn(obj1);
        //assert
        assertNull(keyedObjects2D.getObject(0,0));
        verify(keyedObjects2D,times(1)).addObject(obj1,rowKeyAdd,columnKeyAdd);
    }
    @Test
    public void testAddObject2() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.addObject(obj2,rowKeyAdd,columnKeyAdd);
        when(keyedObjects2D.getObject(0,0)).thenReturn(obj2);
        //assert
        assertEquals(obj2,keyedObjects2D.getObject(0,0));
    }

    @Test
    public void testAddObject3() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        //act
        keyedObjects2D.addObject(obj1,rowKeyNull,columnKeyAdd);
    }

    @Test
    public void testAddObject4() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.addObject(obj1,rowKeyAdd,columnKeyNull);
        //assert
        verify(keyedObjects2D,times(1)).addObject(obj1,rowKeyAdd,columnKeyNull);
    }

    @Test
    public void testSetObject1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.setObject(obj1,rowKey1,columnKey1);
        //assert
        verify(keyedObjects2D,times(1)).setObject(obj1,rowKey1,columnKey1);
    }
    @Test
    public void testSetObject2() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.setObject(obj2,rowKey1,columnKey1);
        //assert
        verify(keyedObjects2D,times(1)).setObject(obj2,rowKey1,columnKey1);

    }
    @Test
    public void testSetObject3() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        keyedObjects2D.setObject(obj2,rowKeyNull,columnKey1);
        //act
        verify(keyedObjects2D,times(1)).setObject(obj2,rowKeyNull,columnKey1);
    }
    @Test
    public void testSetObject4() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        Comparable rowkey =mock(Comparable.class,"1");
        //act
        keyedObjects2D.setObject(obj2,rowkey,columnKeyNull);
        //assert
        verify(keyedObjects2D,times(1)).setObject(obj2,rowkey,columnKeyNull);
    }

    @Test
    public void testRemoveObject1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.removeObject(rowKeyNull,columnKey1);
        //assert
        verify(keyedObjects2D,times(1)).removeObject(rowKeyNull,columnKey1);
    }

    @Test
    public void testRemoveObject2() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.removeObject(rowKey1,columnKeyNull);
        //assert
        verify(keyedObjects2D,times(1)).removeObject(rowKey1,columnKeyNull);
    }

    @Test
    public void testRemoveObject3() {
        //arrange
        KeyedObjects2D keyedObjects2D = mock(KeyedObjects2D.class);
        //act
        doNothing().when(keyedObjects2D).removeObject(isA(Comparable.class),isA(Comparable.class));
        keyedObjects2D.removeObject(rowKey1,columnKey1);
        //assert
        verify(keyedObjects2D,times(1)).removeObject(rowKey1,columnKey1);
    }
    @Test
    public void testRemoveRow1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.removeRow(0);
        //assert
        verify(keyedObjects2D,times(1)).removeRow(0);
    }

    @Test
    public void testRemoveRow2() {
        //arrnage
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        doNothing().when(keyedObjects2D).removeRow(isA(Integer.class));
        keyedObjects2D.removeRow(1);
        //assert
        verify(keyedObjects2D,times(1)).removeRow(1);
    }

    @Test
    public void testRemoveRowComp1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.removeRow(rowKeyNull);
        //assert
        verify(keyedObjects2D,times(1)).removeRow(rowKeyNull);
    }

    @Test(expected = UnknownKeyException.class)
    public void testRemoveRowComp2() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        //act
        keyedObjects2D.removeRow(rowKey1);

    }
    @Test
    public void testRemoveRowComp3() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        doNothing().when(keyedObjects2D).removeRow(isA(Comparable.class));
        keyedObjects2D.removeRow(rowKey2);
        //assert
        verify(keyedObjects2D,times(1)).removeRow(rowKey2);
    }

    @Test
    public void testRemoveColumn1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.removeColumn(0);
        //assert
        verify(keyedObjects2D,times(1)).removeColumn(0);

    }

    @Test
    public void testRemoveColumn2() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        doNothing().when(keyedObjects2D).removeColumn(isA(Integer.class));
        keyedObjects2D.removeColumn(0);
        //assert
        verify(keyedObjects2D,times(1)).removeColumn(0);

    }

    @Test
    public void testRemoveColumnComp1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.removeColumn(columnKeyNull);
        //assert
        verify(keyedObjects2D,times(1)).removeColumn(columnKeyNull);
    }

    @Test(expected = UnknownKeyException.class)
    public void testRemoveColumnComp2() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        //act
        keyedObjects2D.removeRow(columnKey1);

    }
    @Test
    public void testRemoveColumnComp3() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        doNothing().when(keyedObjects2D).removeColumn(isA(Comparable.class));
        keyedObjects2D.removeColumn(columnKey1);
        //assert
        verify(keyedObjects2D,times(1)).removeColumn(columnKey1);
    }

    @Test
    public void testClear1() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        keyedObjects2D.clear();
        //assert
        verify(keyedObjects2D,times(1)).clear();
    }

    @Test
    public void testequals1(){
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        boolean obj = keyedObjects2D.equals(obj1);

        //assert
        assertFalse(obj);
        verify(keyedObjects2D,times(1)).equals(obj1);
    }

    @Test
    public void testequals2(){
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        boolean obj = keyedObjects2D.equals(obj2);

        //assert
        assertFalse(obj);
        verify(keyedObjects2D,times(1)).equals(obj2);
    }

    @Test
    public void testHashCode() {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        int hashCose = keyedObjects2D.hashCode();
        //assert
        verify(keyedObjects2D,times(1)).hashCode();
    }

    @Test
    public void testClone1() throws CloneNotSupportedException {
        //arrange
        KeyedObjects2D keyedObjects2D = spy(KeyedObjects2D.class);
        //act
        Object obj = keyedObjects2D.clone();
        //assert
        verify(keyedObjects2D,times(1)).clone();
    }

    @Test
    public void testGetRowCountIntegration1() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Comparable rowkey= "1";
        Comparable columnKey = "1";
        Object obj = new Object();
        obj=1;
        keyedObjects2D.addObject(obj,rowkey,columnKey);
        //act
        int count = keyedObjects2D.getRowCount();
        //assert
        assertEquals(1,count);
    }

    @Test
    public void testGetRowCountIntegrationTen() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        for(int i=0 ; i<10;i++)
        {
            Object obj = new Object();
            obj = i;
            Comparable rowkey = String.valueOf(i);
            Comparable columnKey =String.valueOf(i);
            keyedObjects2D.addObject(obj,rowkey,columnKey);
        }
        //act
        int count = keyedObjects2D.getRowCount();
        //assert
        assertEquals(10,count);
    }

    @Test
    public void testGetColumnIntegration1() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        Comparable rowKey ="1";
        Comparable columnKey ="1";
        Object obj = new Object();
        obj=2;
        keyedObjects2D.addObject(obj,rowKey,columnKey);
        //act
        int count = keyedObjects2D.getColumnCount();
        //assert
        assertEquals(1,count);
    }

    @Test
    public void testGetColumnCountIntegrationTen() {
        //arrange
        KeyedObjects2D keyedObjects2D = new KeyedObjects2D();
        for(int i=0 ; i<10;i++)
        {
            Object obj = new Object();
            obj = i;
            Comparable rowkey = String.valueOf(i);
            Comparable columnKey =String.valueOf(i);
            keyedObjects2D.addObject(obj,rowkey,columnKey);
        }
        //act
        int count = keyedObjects2D.getColumnCount();
        //assert
        assertEquals(10,count);
    }





















}
