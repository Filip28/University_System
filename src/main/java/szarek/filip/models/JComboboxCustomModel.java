package szarek.filip.models;

import szarek.filip.domain.Student;
import szarek.filip.domain.University;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Filip on 21.06.2017.
 */
public class JComboboxCustomModel<T> extends AbstractListModel implements ComboBoxModel {
    private List<T> itemsObj;
    private List<String> itemsStr;
    private T selectedItemObj;
    private String selectedItemStr;

    public JComboboxCustomModel(List<T> itemsObj)
    {
        this.itemsObj = itemsObj;

        if (this.itemsObj != null && !this.itemsObj.isEmpty())
        {
            selectedItemObj = itemsObj.get(0);
            if (selectedItemObj instanceof Student)
            {
                itemsStr = ((List<Student>)itemsObj).stream().map(o -> o.getName() + " " + o.getSurname()).collect(Collectors.toList());
                selectedItemStr = itemsStr.get(0);
            }
            else if (selectedItemObj instanceof University)
            {
                itemsStr = ((List<University>)itemsObj).stream().map(o -> o.getName()).collect(Collectors.toList());
                selectedItemStr = itemsStr.get(0);
            }

        }
    }

    public void update(List<T> itemsObj)
    {
        this.itemsObj = itemsObj;

        if (this.itemsObj != null && !this.itemsObj.isEmpty())
        {
            selectedItemObj = itemsObj.get(0);
            if (selectedItemObj instanceof Student)
            {
                itemsStr = ((List<Student>)itemsObj).stream().map(o -> o.getName() + " " + o.getSurname()).collect(Collectors.toList());
                selectedItemStr = itemsStr.get(0);
            }
            else if (selectedItemObj instanceof University)
            {
                itemsStr = ((List<University>)itemsObj).stream().map(o -> o.getName()).collect(Collectors.toList());
                selectedItemStr = itemsStr.get(0);
            }

        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItemStr = (String)anItem;
        selectedItemObj = (T)itemsObj.get(itemsStr.indexOf(selectedItemStr));
    }

    @Override
    public Object getSelectedItem() {
        return selectedItemStr;
    }

    public Object getSelectedObjectItem() {
        return selectedItemObj;
    }

    @Override
    public int getSize() {
        return itemsStr.size();
    }

    @Override
    public Object getElementAt(int index) {
        return itemsStr.get(index);
    }
}
