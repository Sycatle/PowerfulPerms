package com.github.cheesesoftware.PowerfulPerms.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Paginator {

    public static List<List<String>> createList(Queue<String> input, int rowsPerPage) {
        int rowWidth = 55;
        List<List<String>> list = new ArrayList<List<String>>();
        while (input.size() > 0) {
            List<String> page = new ArrayList<String>();
            for (int j = 0; j < rowsPerPage; j++) {
                if (input.size() > 0) {
                    String row = input.remove();
                    page.add(row);
                    if (row.length() > rowWidth)
                        j++;

                }
            }
            list.add(page);
        }
        return list;
    }
}
