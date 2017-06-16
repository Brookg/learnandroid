package cn.rabbitb.brook.a26_expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;


public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    // 存放元素的列表
    private LinkedList<Group> groups;
    private LinkedList<LinkedList<Item>> items;
    // 上下文对象
    private Context context;

    // ViewHolder
    private ViewHolderGroup viewHolderGroup;
    private ViewHolderItem viewHolderItem;

    // 构造函数
    public MyExpandableListAdapter(LinkedList<Group> groups, LinkedList<LinkedList<Item>> items, Context context) {
        this.groups = groups;
        this.items = items;
        this.context = context;

        viewHolderGroup = new ViewHolderGroup();
        viewHolderItem = new ViewHolderItem();
    }

    // 要实现的方法
    @Override
    public int getGroupCount() {
        return groups == null ? 0 : groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition) == null ? 0 : items.get(groupPosition).size();
    }

    @Override
    public Group getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Item getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    // 取得用于显示给定分组的视图，这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group, parent, false);

            viewHolderGroup.groupname = (TextView) convertView.findViewById(R.id.groupname);
        }

        viewHolderGroup.groupname.setText(groups.get(groupPosition).getGroupname());

        return convertView;
    }

    // 用于取得显示给定分组给定子项目的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            viewHolderItem.icon = (ImageView) convertView.findViewById(R.id.icon);
            viewHolderItem.name = (TextView) convertView.findViewById(R.id.name);
        }

        viewHolderItem.icon.setImageResource(items.get(groupPosition).get(childPosition).getIcon());
        viewHolderItem.name.setText(items.get(groupPosition).get(childPosition).getName());

        return convertView;
    }

    // 设置子列表是否可以被选中，若返回false，则会触发点击事件
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ViewHolderGroup {
        private TextView groupname;
    }

    private class ViewHolderItem {
        private ImageView icon;
        private TextView name;
    }
}
