package me.TrixxTraxx.Linq;

import java.util.ArrayList;

public class List<E> extends ArrayList<E>
{
    public List()
    {
        super();
    }
    public List(ArrayList<E> list){super(list);}
    public List(java.util.List<E> l){super(l);}
    public List(E ... elements){
        super();
        
    }
    public List(E element){
        super();
        add(element);
    }
    public List(int size){
        super(size);
    }
    
    public void addAll(E ... elements){
        for(E x : elements)
        {
            add(x);
        }
    }
    
    public void removeAll(Find<E> find)
    {
        removeAll(findAll(find));
    }
    
    public void addAll(List<E> list){
        for(E x : list)
        {
            add(x);
        }
    }
    
    public void addAll(java.util.List<E> list){
        for(E x : list)
        {
            add(x);
        }
    }
    
    public void addAll(ArrayList<E> list){
        for(E x : list)
        {
            add(x);
        }
    }
    
    public List<E> getRange(int start, int end){
        List<E> list = new List<E>();
        for(int i = start; i < end; i++)
        {
            list.add(this.get(i));
        }
        return list;
    }
    
    public List<E> getRange(int start){
        return getRange(start, this.size());
    }
    
    public List<E> getRange(int start, int end, int step){
        List<E> list = new List<E>();
        for(int i = start; i < end; i+=step)
        {
            list.add(this.get(i));
        }
        return list;
    }
    
    public interface Find<E>{
        public boolean match(E e);
    }
    
    public E find(Find<E> find){
        for(E x : this)
        {
            if(find.match(x))
                return x;
        }
        return null;
    }
    
    public List<E> findAll(Find<E> find){
        List<E> list = new List<E>();
        for(E x : this)
        {
            if(find.match(x)) list.add(x);
        }
        return list;
    }
    
    public interface Value<E>{
        public double value(E e);
    }
    
    public E max(Value<E> value){
        E max = null;
        double maxValue = Double.MIN_VALUE;
        for(E x : this)
        {
            double v = value.value(x);
            if(v > maxValue)
            {
                max = x;
                maxValue = v;
            }
        }
        return max;
    }
    
    public E min(Value<E> value){
        E min = null;
        double minValue = Double.MAX_VALUE;
        for(E x : this)
        {
            double v = value.value(x);
            if(v < minValue)
            {
                min = x;
                minValue = v;
            }
        }
        return min;
    }
    
    public double sum(Value<E> value){
        double sum = 0;
        for(E x : this)
        {
            sum += value.value(x);
        }
        return sum;
    }
    
    public double avg(Value<E> value)
    {
        return sum(value) / size();
    }
    
    public E first(){
        return get(0);
    }
    
    public E last(){
        return get(size() - 1);
    }
    
    public List<E> reverse(){
        List<E> list = new List<E>();
        for(int i = size() - 1; i >= 0; i--)
        {
            list.add(get(i));
        }
        return list;
    }
    
    public E random(){
        return get((int) (Math.random() * size()));
    }
    
    public List<E> shuffle(){
        List<E> list = new List<E>();
        for(int i = 0; i < size(); i++)
        {
            list.add(get((int) (Math.random() * size())));
        }
        return list;
    }
    
    public List<E> shuffle(int times){
        List<E> list = new List<E>();
        for(int i = 0; i < times; i++)
        {
            list.addAll(shuffle());
        }
        return list;
    }
    
    public List<E> take(int n){
        List<E> list = new List<E>();
        for(int i = 0; i < n; i++)
        {
            list.add(get(i));
        }
        return list;
    }
    
    public List<E> takeWhile(Find<E> find){
        List<E> list = new List<E>();
        for(E x : this)
        {
            if(!find.match(x)) break;
            list.add(x);
        }
        return list;
    }
    
    public List<E> takeLast(int n){
        //return the last n elements without using reverse
        List<E> list = new List<E>();
        for(int i = size() - n; i < size(); i++)
        {
            list.add(get(i));
        }
        return list;
    }
    
    public List<E> takeLastWhile(Find<E> find){
        //return the last elements without using reverse
        List<E> list = new List<E>();
        for(int i = size() - 1; i >= 0; i--)
        {
            if(!find.match(get(i))) break;
            list.add(get(i));
        }
        return list;
    }
}
