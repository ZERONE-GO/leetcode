package p0341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    
    private List<Integer> values;
    private int index;
    private int size;

    public NestedIterator(List<NestedInteger> nestedList) {
        values = new ArrayList<Integer>();
        index = 0;
        toValues(values, nestedList);
        size = values.size();
    }

    private void toValues(List<Integer> values, List<NestedInteger> nestedList) {
        if(nestedList == null) {
            return;
        }
        
        for(NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()) {
                values.add(nestedInteger.getInteger());
            } else {
                toValues(values, nestedInteger.getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        Integer value = values.get(index);
        index ++;
        return value;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }
}
