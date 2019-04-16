// SpaceTraderInC++.cpp : Defines the entry point for the application.
//

#include "framework.h"
#include "SpaceTraderInC++.h"
#include <string>

#define MAX_LOADSTRING 100

// Global Variables:
HINSTANCE hInst;                                // current instance
WCHAR szTitle[MAX_LOADSTRING];                  // The title bar text
WCHAR szWindowClass[MAX_LOADSTRING];            // the main window class name

// Forward declarations of functions included in this code module:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);

int APIENTRY wWinMain(_In_ HINSTANCE hInstance,
                     _In_opt_ HINSTANCE hPrevInstance,
                     _In_ LPWSTR    lpCmdLine,
                     _In_ int       nCmdShow)
{
    UNREFERENCED_PARAMETER(hPrevInstance);
    UNREFERENCED_PARAMETER(lpCmdLine);

    // TODO: Place code here.
	

    // Initialize global strings
    LoadStringW(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
    LoadStringW(hInstance, IDC_SPACETRADERINC, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // Perform application initialization:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_SPACETRADERINC));

    MSG msg;

    // Main message loop:
    while (GetMessage(&msg, nullptr, 0, 0))
    {
        if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg))
        {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    }

    return (int) msg.wParam;
}



//
//  FUNCTION: MyRegisterClass()
//
//  PURPOSE: Registers the window class.
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
    WNDCLASSEXW wcex;

    wcex.cbSize = sizeof(WNDCLASSEX);

    wcex.style          = CS_HREDRAW | CS_VREDRAW;
    wcex.lpfnWndProc    = WndProc;
    wcex.cbClsExtra     = 0;
    wcex.cbWndExtra     = 0;
    wcex.hInstance      = hInstance;
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_SPACETRADERINC));
    wcex.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = MAKEINTRESOURCEW(IDC_SPACETRADERINC);
    wcex.lpszClassName  = szWindowClass;
    wcex.hIconSm        = LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));

    return RegisterClassExW(&wcex);
}

//
//   FUNCTION: InitInstance(HINSTANCE, int)
//
//   PURPOSE: Saves instance handle and creates main window
//
//   COMMENTS:
//
//        In this function, we save the instance handle in a global variable and
//        create and display the main program window.
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   hInst = hInstance; // Store instance handle in our global variable

   HWND m_hwnd = CreateWindowW(szWindowClass, szTitle, WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, nullptr, nullptr, hInstance, nullptr);

   if (!m_hwnd)
   {
      return FALSE;
   }

   ShowWindow(m_hwnd, nCmdShow);
   UpdateWindow(m_hwnd);

   return TRUE;
}

//
//  FUNCTION: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  PURPOSE: Processes messages for the main window.
//
//  WM_COMMAND  - process the application menu
//  WM_PAINT    - Paint the main window
//  WM_DESTROY  - post a quit message and return
//
//
LRESULT CALLBACK WndProc(HWND m_hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    switch (message)
    {
	case WM_CREATE:
		{
			HWND hwndNameTextBox = CreateWindow(L"Edit",
				L"Enter your name here",
				WS_BORDER | WS_VISIBLE | WS_CHILD,
				10, 10, 400, 20,
				m_hwnd, (HMENU) 1000, NULL, NULL);

			HWND hwndPilotSkillTextBox = CreateWindow(L"Edit",
				L"Enter your pilot skill here (0-10)",
				WS_BORDER | WS_VISIBLE | WS_CHILD,
				10, 50, 250, 20,
				m_hwnd, (HMENU) 1001, NULL, NULL);

			HWND hwndFighterSkillTextBox = CreateWindow(L"Edit",
				L"Enter your fighter skill here (0-10)",
				WS_BORDER | WS_VISIBLE | WS_CHILD,
				10, 80, 250, 20,
				m_hwnd, (HMENU)1002, NULL, NULL);

			HWND hwndTraderSkillTextBox = CreateWindow(L"Edit",
				L"Enter your trader skill here (0-10)",
				WS_BORDER | WS_VISIBLE | WS_CHILD,
				10, 110, 250, 20,
				m_hwnd, (HMENU)1003, NULL, NULL);

			HWND hwndEngineerSkillTextBox = CreateWindow(L"Edit",
				L"Enter your engineer skill here (0-10)",
				WS_BORDER | WS_VISIBLE | WS_CHILD,
				10, 140, 250, 20,
				m_hwnd, (HMENU)1004, NULL, NULL);

			HWND hwndDifficultyTextBox = CreateWindow(L"Edit",
				L"Enter your difficulty here (Easy, Medium, Hard, Impossible)",
				WS_BORDER | WS_VISIBLE | WS_CHILD,
				10, 180, 400, 20,
				m_hwnd, (HMENU)1005, NULL, NULL);

			HWND hwndButton = CreateWindow(
				L"BUTTON",  // Predefined class; Unicode assumed 
				L"OK",      // Button text 
				WS_TABSTOP | WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON,  // Styles 
				10,         // x position 
				350,         // y position 
				100,        // Button width
				50,        // Button height
				m_hwnd,     // Parent window
				(HMENU)1006,       // No menu.
				NULL,
				NULL);      // Pointer not needed.

			break;
		}
    case WM_COMMAND:
        {
            int wmId = LOWORD(wParam);
            // Parse the menu selections:
            switch (wmId)
            {
			case 1006:
				{
					std::string input;
					GetWindowText(GetDlgItem (m_hwnd, 1000), (LPWSTR) reinterpret_cast <char*> ((char*)input.c_str()), 100);
					MessageBox(m_hwnd, (LPWSTR) input.c_str(), L"", MB_OK);
				}
				break;
            case IDM_ABOUT:
                DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), m_hwnd, About);
                break;
            case IDM_EXIT:
                DestroyWindow(m_hwnd);
                break;
            default:
                return DefWindowProc(m_hwnd, message, wParam, lParam);
            }
        }
        break;
    case WM_PAINT:
        {
            PAINTSTRUCT ps;
            HDC hdc = BeginPaint(m_hwnd, &ps);
            // TODO: Add any drawing code that uses hdc here...
			


            EndPaint(m_hwnd, &ps);
        }
        break;
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(m_hwnd, message, wParam, lParam);
    }
    return 0;
}

// Message handler for about box.
INT_PTR CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
    UNREFERENCED_PARAMETER(lParam);
    switch (message)
    {
    case WM_INITDIALOG:
        return (INT_PTR)TRUE;

    case WM_COMMAND:
        if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL)
        {
            EndDialog(hDlg, LOWORD(wParam));
            return (INT_PTR)TRUE;
        }
        break;
    }
    return (INT_PTR)FALSE;
}
