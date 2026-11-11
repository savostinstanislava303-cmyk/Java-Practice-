package practice10;


public class task7 {
    abstract static class UiWidget {
        protected String id;
        protected int width;
        protected int height;
        public UiWidget(String id, int width, int height) {
            this.id = id;
            this.width = width;
            this.height = height;
        }

        public abstract String renderHtml();
    }
    static class ButtonWidget extends UiWidget {
        private String label;
        public ButtonWidget(String id, int width, int height, String label) {
            super(id, width, height);
            this.label = label;
        }
        @Override
        public String renderHtml() {
            return "<button id=\"" + id + "\" style=\"width:" + width +
                    "px; height:" + height + "px;\">" + label + "</button>";
        }
    }
    static class TextInputWidget extends UiWidget {
        private String placeholder;
        public TextInputWidget(String id, int width, int height, String placeholder) {
            super(id, width, height);
            this.placeholder = placeholder;
        }
        @Override
        public String renderHtml() {
            return "<input type=\"text\" id=\"" + id +
                    "\" placeholder=\"" + placeholder +
                    "\" style=\"width:" + width +
                    "px; height:" + height + "px;\">";
        }
    }
    static class ProgressBarWidget extends UiWidget {
        private int progressPercent;
        public ProgressBarWidget(String id, int width, int height, int progressPercent) {
            super(id, width, height);
            if (progressPercent < 0 || progressPercent > 100) {
                throw new IllegalArgumentException("Прогрес має бути від 0 до 100");
            }
            this.progressPercent = progressPercent;
        }
        @Override
        public String renderHtml() {
            return "<div id=\"" + id + "\" style=\"width:" + width +
                    "px; height:" + height +
                    "px; background-color: lightgray;\">" +
                    "<div style=\"width:" + progressPercent +
                    "%; height:100%; background-color: green;\"></div>" +
                    "</div>";
        }
    }
    public static String buildHtmlPage(UiWidget[] pageElements) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("<title>My UI Page</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        for (UiWidget widget : pageElements) {
            html.append(widget.renderHtml()).append("\n");
        }
        html.append("</body>\n");
        html.append("</html>");
        return html.toString();
    }
    public static void main(String[] args) {
        UiWidget[] pageElements = {
                new ButtonWidget("btn1", 120, 40, "Натисни мене"),
                new TextInputWidget("input1", 200, 35, "Введіть ім'я"),
                new ProgressBarWidget("progress1", 250, 20, 75)
        };
        String htmlPage = buildHtmlPage(pageElements);
        System.out.println(htmlPage);
    }
}

