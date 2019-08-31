import java.util.*;

public class L1169_InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        if (transactions == null || transactions.length == 0) {
            return res;
        }
        Set<String> resSet = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] items = transactions[i].split(",");
            if (Integer.parseInt(items[2]) > 1000) {
                resSet.add(transactions[i]);
            }
            // 以name做key，city+time+index的List 为value
            List<String> timeList = map.getOrDefault(items[0], new ArrayList<>());
            if ( timeList.size() != 0) {
                for (String timeIndex : timeList) {
                    String[] timeAndIndex = timeIndex.split(" ");
                    String city = timeAndIndex[0];
                    if (city.equals(items[3])) {
                        continue;
                    } else {
                        int time = Integer.parseInt(timeAndIndex[1]);
                        int index = Integer.parseInt(timeAndIndex[2]);
                        if (Math.abs(time - Integer.parseInt(items[1])) <= 60) {
                            resSet.add(transactions[index]);
                            resSet.add(transactions[i]);
                        }
                    }
                }
            }
            timeList.add(items[3] + " " + items[1] + " " + i);
            map.put(items[0], timeList);
        }
        res = new ArrayList<>(resSet);
        return res;
    }

    /**
     * leetcode上别人的解法
     */
    private class Trade {
        private String s;
        private String name;
        private int time;
        private int money;
        private String city;
        private boolean valid;

        public Trade(String s, String name, int time, int money, String city) {
            super();
            this.s = s;
            this.name = name;
            this.time = time;
            this.money = money;
            this.city = city;
            this.valid = this.money > 1000 ? false : true;
        }

        @Override
        public String toString() {
            return s;
        }

        private boolean invalid(Trade o) {
            return this.name.equals(o.name) && !this.city.equals(o.city)
                    && Math.abs(this.time - o.time) <= 60;
        }
    }

    public List<String> invalidTransactions2(String[] transactions) {
        List<String> result = new ArrayList<String>();
        List<Trade> trades = new ArrayList<Trade>();
        //先加入数组中
        for (String s : transactions) {
            String[] split = s.split(",");
            Trade t = new Trade(s, split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                    split[3]);
            trades.add(t);
        }
        //判断
        for (int i = 0; i < trades.size(); i++) {
            Trade iTrade = trades.get(i);
            if (!iTrade.valid) {
                continue;
            }
            for (int j = 0; j < trades.size(); j++) {
                if (i == j) {
                    continue;
                }
                Trade jTrade = trades.get(j);
                if (iTrade.invalid(jTrade)) {
                    // 外部类能访问内部类的私有属性
                    iTrade.valid = false;
                    jTrade.valid = false;
                }
            }
        }
        for (Trade t : trades) {
            if (!t.valid) {
                result.add(t.toString());
            }
        }
        return result;
    }
}
