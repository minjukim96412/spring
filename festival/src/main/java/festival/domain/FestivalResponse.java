package festival.domain;

import java.util.List;

public class FestivalResponse {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {
        private Body body;

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }
    }

    public static class Body {
        private Items items;

        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }
    }

    public static class Items {
        private List<Festival> item;

        public List<Festival> getItem() {
            return item;
        }

        public void setItem(List<Festival> item) {
            this.item = item;
        }
    }
}
