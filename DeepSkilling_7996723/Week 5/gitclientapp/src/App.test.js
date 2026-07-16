import { render, screen } from "@testing-library/react";
import App from "./App";

test("renders repository names heading", () => {
  render(<App />);
  const heading = screen.getByText(/repository names/i);
  expect(heading).toBeInTheDocument();
});