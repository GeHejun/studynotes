public class SmoothWeightedRoundRobin {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

        }
    }


    class Item {

        private Integer weight;

        private Integer currentWeight;

        private String name;

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getCurrentWeight() {
            return currentWeight;
        }

        public void setCurrentWeight(Integer currentWeight) {
            this.currentWeight = currentWeight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
