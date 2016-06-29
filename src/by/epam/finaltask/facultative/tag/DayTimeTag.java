package by.epam.finaltask.facultative.tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

@SuppressWarnings("serial")
public class DayTimeTag extends TagSupport {
    private String locale;
    private String dayTime;
    private  static final String dayTimeMorning="morning";
    private static final String EN = "en";
    private static final String EN_MORNING = "Morning group";
    private static final String EN_EVENING = "Evening group";
    private static final String RU_MORNING = "Утренняя группа";
    private static final String RU_EVENING = "Вечерняя группа";

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    @Override
    public int doStartTag() throws JspException {
        try {

            String currentDayTime;
            if (dayTimeMorning.equalsIgnoreCase(dayTime) ) {
                if (EN.equalsIgnoreCase(locale)) {
                    currentDayTime = EN_MORNING;
                } else {
                    currentDayTime = RU_MORNING;
                }
            } else {
                if (EN.equalsIgnoreCase(locale) ) {
                    currentDayTime = EN_EVENING;
                } else {
                    currentDayTime = RU_EVENING;
                }
            }

            pageContext.getOut().write(currentDayTime);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

}

