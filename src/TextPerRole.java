public class TextPerRole {
	public static void printTextPerRole(String[] roles, String[] textLines) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < roles.length; i++) {
			stringBuilder.append("\n" + roles[i] + ":\n");
			for (int j = 0; j < textLines.length; j++) {
				if (textLines[j].trim().startsWith(roles[i].trim() + ":")) {
					stringBuilder.append((j + 1) + ")" + textLines[j].substring(roles[i].trim().length() + 1) + "\n");
				}
			}
		}
		System.out.println(stringBuilder);
	}

	public static void main(String[] args) {
		String[] roles = {
				"Городничий", "Аммос Федорович",
				"Артемий Филиппович",
				"Лука Лукич"};
		String[] textLines = {
				"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие:",
				"Аммос Федорович: Как ревизор?",
				"Артемий Филиппович: Как ревизор?",
				"Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
				"Аммос Федорович: Вот те на!",
				"Артемий Филиппович: Вот не было заботы, так подай!",
				"Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

		printTextPerRole(roles, textLines);
	}
}
