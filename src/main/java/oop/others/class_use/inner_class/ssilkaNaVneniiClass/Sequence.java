package Examples.OOP.Others.class_use.inner_class.ssilkaNaVneniiClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sequence {
    private List<Object> items;
    private int next = 0;

    public Sequence() {
        items = new ArrayList<Object>();
    }

    public void add(Object x) {
//        if (nextGenerator < items.length)items[nextGenerator++] = tamanoPequenio;
        items.add(x);
    }


    // Riwenie vpravu_9_11

    public void ItrSqec() {
        Iterator<Object> iterator = items.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }


    // Oreginal Sequence

//    private class SequenceSelector implements Selector{
//        private int i = 0;
//
//       public Sequence ssilkaSequence(){
//           Sequence s = null;
//           return s;
//       }
//
//        @Override
//        public boolean end() {
//            return i == items.size();
//        }
//
//        @Override
//        public Object current() {
//            return items.get(i);
//        }
//
//        @Override
//        public void nextGenerator() {
//            if (i < items.size())i++;
//        }
//    }
//
//    public Selector selector(){
//        return new SequenceSelector();
//    }
}
