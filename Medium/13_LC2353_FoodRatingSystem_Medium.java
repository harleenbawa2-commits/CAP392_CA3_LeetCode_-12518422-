import java.util.*;

class FoodRatings {

    HashMap<String, String> foodCuisine;
    HashMap<String, Integer> foodRating;
    HashMap<String, TreeSet<String>> cuisineFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        foodCuisine = new HashMap<>();
        foodRating = new HashMap<>();
        cuisineFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {

            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);

            cuisineFoods.putIfAbsent(cuisines[i],
                new TreeSet<>((a, b) -> {

                    int ratingCompare = Integer.compare(
                        foodRating.get(b), foodRating.get(a));

                    if (ratingCompare != 0) {
                        return ratingCompare;
                    }

                    return a.compareTo(b);
                }));

            cuisineFoods.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {

        String cuisine = foodCuisine.get(food);

        // Remove food before changing its rating
        cuisineFoods.get(cuisine).remove(food);

        // Update rating
        foodRating.put(food, newRating);

        // Add food again with updated rating
        cuisineFoods.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {

        return cuisineFoods.get(cuisine).first();
    }
}
