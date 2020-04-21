public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
    Set<T> setUnique1 = new HashSet(set1);
    setUnique1.addAll(set2);
    setUnique1.removeAll(set2);
    
    Set<T> setUnique = new HashSet(set1);
    setUnique.addAll(set2);
    setUnique.removeAll(set1);
    
    setUnique1.addAll(setUnique);

    return setUnique1;
}