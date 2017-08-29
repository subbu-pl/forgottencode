import { Angular4boilerplatePage } from './app.po';

describe('angular4boilerplate App', () => {
  let page: Angular4boilerplatePage;

  beforeEach(() => {
    page = new Angular4boilerplatePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
