package data_struct.lists;

/**
 * 链表方法定义
 *
 * @author Dong
 */

public interface ListInterface<E> {

    /**
     * 判断链表是否为空
     *
     * @return 如果为空，返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 获取链表的元素个数，如果超过{@code Integer.MAX_VALUE}，则返回{@code Integer.MAX_VALUE}
     * 其他情况返回链表元素个数
     *
     * @return 链表中元素的个数
     */
    int size();

    /**
     * 向链表末尾插入一个数据，当数据非法的时候，则返回失败
     *
     * @param e 目标数据
     * @return 是否成功
     */
    boolean insert(E e);

    /**
     * 向链表指定位置插入一条数据
     * <p>
     * 当index == size()的时候，与insert相同
     *
     * @param index 指定位置
     * @param e     被插入数据
     * @return 是否成功
     */
    boolean insert(int index, E e);

    /**
     * 删除第一个出现的目标值，如果链表内没有目标值，则删除失败
     *
     * @param e 指定目标值
     * @return 是否成功删除
     */
    boolean delete(E e);

    /**
     * 删除指定位置的数据
     * <p>
     * 输入指定位置没有数据，则返回null
     *
     * @param index 目标位置
     * @return 被删除的数据值
     */
    E delete(int index);


    /**
     * 修改指定位置的数据，如果指定没有数据，则不进行修改，且返回null
     *
     * @param index    指定位置
     * @param newValue 修改后的数据
     * @return 修改前的数据
     */
    E update(int index, E newValue);

    /**
     * 将第一个出现的oldValue更新为newValue
     * <p>
     * 当没有oldValue的时候，返回false
     *
     * @param oldValue 旧数据
     * @param newValue 新数据
     * @return 如果操作完成返回true
     */
    boolean update(E oldValue, E newValue);


    /**
     * 查找指定数据第一次出现的位置，如果没有指定数据则返回-1
     *
     * @param e 指定数据
     * @return 出现的位置
     */
    int searchFirstIndex(E e);

    /**
     * 获取指定位置上的数据值
     *
     * @param index 指定位置
     * @return 数据值
     */
    E getE(int index);

    /**
     * 清楚链表数据
     */
    void clean();
}
