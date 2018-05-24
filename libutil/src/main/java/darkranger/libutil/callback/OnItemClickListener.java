package darkranger.libutil.callback;

/**
 * 创建者  : 唐朝
 * 创建时间: 2017/8/9.
 * 类名    :常用recyclerView listview gridview条目点击监听
 * 类功能  :
 */

public interface OnItemClickListener<T> {
    void onItemClick(T t, int position);
}
