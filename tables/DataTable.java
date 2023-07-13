package tables;

import types.TypeData;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public final class DataTable{

    private List<Data> dataTable = new ArrayList<Data>();

    public void addData(String nameData, TypeData typeData, String initData){

        if(typeData == TypeData.ASCIIZ ){
            if(!initData.equals("")){
                initData = initData.substring(1, initData.length() - 1);
            }
            initData = "\"" + initData + "\"";
        }

        Data newData = new Data(nameData,typeData,initData);

        dataTable.add(newData);
    }

    public String getNameData(int line){
        return dataTable.get(line).NameData;
    }

    public TypeData getTypeData(int line){
        return dataTable.get(line).TypeData;
    }

    public String getInitData(int line){
        return dataTable.get(line).InitData;
    }

    public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format(".data\n");
		for (int i = 0; i < dataTable.size(); i++) {
			f.format("%s:       %s          %s\n", getNameData(i),
            getTypeData(i).toString(), getInitData(i));
		}
		f.close();
		return sb.toString();
	}

    private static final class Data{

        private final String NameData;
        private final TypeData TypeData;
        private final String InitData;

        public Data(String nameData, TypeData typeData, String initData){
            this.NameData = nameData;
            this.TypeData = typeData;
            this.InitData = initData;
        }

    }


}