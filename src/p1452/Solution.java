package p1452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList<Integer>();
        List<Set<String>> sets = new ArrayList<>(favoriteCompanies.size());
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            Set<String> set = new HashSet<String>(favoriteCompanies.get(i));
            sets.add(set);
        }
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> companies = favoriteCompanies.get(i);
            boolean sub = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (companies.size() <= favoriteCompanies.get(j).size()&&i != j) {
                    boolean contains = true;
                    for (int k = 0; k < companies.size(); k++) {
                        if (!sets.get(j).contains(companies.get(k))) {
                            contains = false;
                            break;
                        }
                    }
                    if (contains) {
                        sub = true;
                        break;
                    }
                }
            }
            if (!sub) {
                result.add(i);
            }
        }

        return result;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        List<String> company1 = Arrays.asList("a", "b", "c");
        List<String> company2 = Arrays.asList("a", "b");
        List<String> company3 = Arrays.asList("a", "b", "c","d");
        
        favoriteCompanies.add(company1);
        favoriteCompanies.add(company2);
        favoriteCompanies.add(company3);
        s.peopleIndexes(favoriteCompanies);
    }

}
